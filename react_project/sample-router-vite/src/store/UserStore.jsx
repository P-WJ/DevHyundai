import { createContext, useState } from "react";
export const UserContext = createContext(null);

// vue의 slot과 같음
// 모든 요소가 올 수 있음
// app.js를 전부 감싸버림 router 포함
// app.js의 모든 요소들이 자식으로 들어옴 => context의 상태가 컴포넌트에서 사용가능

const UserStore = (props) => {
  const [userId, setUserId] = useState("");
  const [password, setPassword] = useState("");
  const [name, setName] = useState("");

  return (
    <UserContext.Provider
      value={{
        userId,
        setUserId,
        password,
        setPassword,
        name,
        setName,
      }}
    >
      {props.children}
    </UserContext.Provider>
  );
};
export default UserStore;
