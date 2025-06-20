import "./App.css";
import { Route, BrowserRouter, Routes } from "react-router-dom";

import Chat from "./Chat";
import ChatRoomCreate from "./ChatRoomCreate";
import Chatting from "./Chatting";
// import ChatList from "./ChatList";
function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/chat" element={<Chat />} />
          <Route path="/chat-create" element={<ChatRoomCreate />} />
          <Route path="/chatting/:roomId" element={<Chatting />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
