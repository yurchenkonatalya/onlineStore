import React from "react";
import style from "./SendButton.module.css"

import { Button } from "react-bootstrap";

const SendButton = ({sendDataCallback, children}) =>{


return(
<Button variant="success" className={style.btnSend} onClick={sendDataCallback}>{children}</Button>
)

}


export default SendButton