import axios from "axios";
const KH_DOMAIN = "http://localhost:8111";
const tokenn = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0IiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTc1MDMyODkxM30.v4NQ7TSdp34dHC9ALYOCCxEDPBVMq2aNyvEk9lJ54HdTXW7tXjX0RSxayGDGjy7EH_SGAhnY36qEHF18I2pn1w";

const AxiosApi = {
  // 로그인
  login: async (email, pw) => {
    console.log("이메일 : ", email);
    console.log("패스워드 : ", pw);
    const login = {
      email: email,
      pwd: pw,
    };
    return await axios.post(KH_DOMAIN + "/auth/login", login);
  },
  // 가입여부 확인
  regCheck: async (email) => {
    return await axios.get(KH_DOMAIN + `/auth/exists/${email}`);
  },
  // 회원 가입
  signup: async (email, pw, name) => {
    console.log("이메일 : ", email);
    console.log("패스워드 : ", pw);
    console.log("이름 : ", name);
    const member = {
      email: email,
      pwd: pw,
      name: name,
      imgPath: "",
    };
    return await axios.post(KH_DOMAIN + `/auth/signup`, member,  {
                                                                      headers: {
        Authorization: "Bearer " + tokenn // or whatever your token is
                                                                      }
                                                                     });
  },
  // 전체 회원 조회
  memberList: async () => {
    return await axios.get(KH_DOMAIN + "/member/list",  {
                                                             headers: {
        Authorization: "Bearer " + tokenn // or whatever your token is
                                                             }
                                                            });
  },
  // 개별 회원 조회
  memberInfo: async (email) => {
    return await axios.get(KH_DOMAIN + `/member/${email}`, {
                                                                 headers: {
        Authorization: "Bearer " + tokenn // or whatever your token is
                                                                 }
                                                                });
  },
  // 채팅방 목록 가져 오기
  chatList: async () => {
    return await axios.get(KH_DOMAIN + "/chat/list",  {
                                                           headers: {
        Authorization: "Bearer " + tokenn // or whatever your token is
                                                           }
                                                          });
  },
  // 채팅방 생성하기
  chatCreate: async (email, name) => {
    console.log(email, name);
    const chat = {
      email: email,
      name: name,
    };
    return await axios.post(KH_DOMAIN + "/chat/new", chat,  {
                                                                 headers: {
        Authorization: "Bearer " + tokenn// or whatever your token is
                                                                 }
                                                                });
  },
  // 채팅방 정보 가져오기
  chatDetail: async (roomId) => {
    return await axios.get(KH_DOMAIN + `/chat/room/${roomId}`, {
      headers: {
        Authorization: "Bearer " + tokenn // or whatever your token is
      }
     });

  },
};

export default AxiosApi;
