import React from "react";

interface User {
  name: string;
  age: number;
  isAdult: boolean;
}

interface UserProps {
  user: User;
}
{
  /* <Userprops> 어떤 것을 받는지 명시 */
}
const UserComp: React.FC<UserProps> = ({ user }) => {
  return (
    <div>
      <h3>인터페이스 예시</h3>
      <p>Name: {user.name}</p>
      <p>Age: {user.age}</p>
      <p>Is Adult: {user.isAdult ? "Yes" : "No"}</p>
    </div>
  );
};

export default UserComp;
