import { useState, useEffect, useRef } from "react";
import AxiosApi from "./AxiosApi";
import styled from "styled-components";
import { useNavigate, useParams } from "react-router-dom";

const ChatContainer = styled.div`
  padding: 20px;
  max-width: 800px;
  margin: 0 auto;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
`;

const ChatHeader = styled.div`
  font-size: 1.5em;
  color: #333;
  text-align: center;
  margin-bottom: 20px;
`;

const MessagesContainer = styled.div`
  display: flex;
  flex-direction: column;
  height: 400px;
  overflow-y: auto;
  border-top: 1px solid #ddd;
  border-bottom: 1px solid #ddd;
  padding: 10px;
  margin-bottom: 20px;
`;

const Message = styled.div`
  max-width: 60%;
  padding: 10px;
  margin: 10px;
  border-radius: 20px;
  background-color: ${(props) => (props.isSender ? "#DCF8C6" : "#E0E0E0")};
  align-self: ${(props) => (props.isSender ? "flex-end" : "flex-start")};
  border: 1px solid ${(props) => (props.isSender ? "#DCF8C6" : "#E0E0E0")};
`;

const Input = styled.input`
  padding: 10px;
  width: 70%;
  border-radius: 4px;
  border: 1px solid #ddd;
`;

const Button = styled.button`
  padding: 10px 15px;
  border: none;
  border-radius: 4px;
  margin-left: 10px;
  cursor: pointer;
  color: white;
  box-shadow: 1px 1px 1px #ccc;
  background-color: ${(props) => (props.color ? props.color : "#4caf50")};

  &:hover {
    background-color: ${(props) =>
      props.hoverColor ? props.hoverColor : "#45a049"};
  }
`;

const Chatting = () => {
  const [socketConnected, setSocketConnected] = useState(false); // 웹소켓 연결 여부
  const [inputMsg, setInputMsg] = useState(""); // 입력 메시지
  const [chatList, setChatList] = useState([]); // 채팅 글 목록
  const { roomId } = useParams(); // 채팅방 번호, 새로운 방 개설, 기존의 방에 대한 진입
  const [sender, setSender] = useState(""); // 보낸 사람
  const [roomName, setRoomName] = useState(""); // 채팅방 이름
  const ws = useRef(null); // 웹소켓 객체 생성, 소켓 연결 정보를 유지 해야 하지만 렌더링과는 무관
  const chatContainerRef = useRef(null);
  const navigate = useNavigate(); // 페이지 이동

  useEffect(() => {
    setSender("jks2024@gmail.com");
  }, []);

  const scrollToBottom = () => {
    if (chatContainerRef.current) {
      chatContainerRef.current.scrollTop =
        chatContainerRef.current.scrollHeight;
    }
  };

  const onChangeMsg = (e) => {
    setInputMsg(e.target.value);
  };

  const onClickMsgSend = (e) => {
    //  메시지 전송
    ws.current.send(
      JSON.stringify({
        type: "TALK",
        roomId: roomId,
        sender: sender,
        message: inputMsg,
      })
    );
    setInputMsg(""); // 전송 이후 입력창 지우기
  };
  const onEnterKey = (e) => {
    // 엔티키 입력 시, 공백 제거 후 비어있지 않으면
    if (e.key === "Enter" && inputMsg.trim() !== "") {
      e.preventDefault(); // 기존 이벤트 무시
      onClickMsgSend(e);
    }
  };
  // 채팅 종료
  const onClickMsgClose = () => {
    //  메시지 전송
    ws.current.send(
      JSON.stringify({
        type: "CLOSE",
        roomId: roomId,
        sender: sender,
        message: inputMsg,
      })
    );
    ws.current.close();
    navigate("/chat"); //  채팅 목록 이동
  };

  // 채팅방 정보 가져 오기
  useEffect(() => {
    const getChatRoom = async () => {
      try {
        const response = await AxiosApi.chatDetail(roomId);
        console.log("채팅방 정보 가져 오기", response.data.name);
        setRoomName(response.data.name);
      } catch (e) {
        console.log(e);
      }
    };
    getChatRoom();
  }, []);

  // 웹 소켓 연결 하기
  useEffect(() => {
    if (!ws.current) {
      ws.current = new WebSocket("ws://localhost:8111/ws/chat");
      ws.current.onopen = () => {
        setSocketConnected(true);
      };
    }

    if (socketConnected && sender) {
      ws.current.send(
        JSON.stringify({
          type: "ENTER",
          roomId: roomId,
          sender: sender,
          message: "입장 합니다.",
        })
      );
    }
    ws.current.onmessage = (msg) => {
      const data = JSON.parse(msg.data);
      setChatList((prev) => [...prev, data]); // 기존의 채팅 리스트에 새로운 메시지 추가
      scrollToBottom();
    };
  }, [socketConnected, sender]);

  return (
    <ChatContainer>
      <ChatHeader>채팅방 {roomName}</ChatHeader>
      <MessagesContainer ref={chatContainerRef}>
        {chatList.map((chat, index) => (
          <Message key={index} isSender={chat.sender === sender}>
            {`${chat.sender} > ${chat.message}`}
          </Message>
        ))}
      </MessagesContainer>
      <div>
        <Input
          placeholder="문자 전송"
          value={inputMsg}
          onChange={onChangeMsg}
          onKeyUp={onEnterKey}
        />
        <Button onClick={onClickMsgSend}>전송</Button>
      </div>
      <Button color="#f44336" hoverColor="#d32f2f" onClick={onClickMsgClose}>
        채팅 종료 하기
      </Button>
    </ChatContainer>
  );
};
export default Chatting;