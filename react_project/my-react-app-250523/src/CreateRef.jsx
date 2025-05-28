// 실제 DOM을 제어하기 위해 사용되는 useRef()
import { useRef } from "react";

const CreateRef = () => {
  const inputRef = useRef(null);

  const handleFocus = () => {
    inputRef.current.disabled = false;
    inputRef.current.focus();
  };
  return (
    <>
      <input disabled ref={inputRef} />
      <button onClick={handleFocus}>활성화</button>
    </>
  );
};

export default CreateRef;
