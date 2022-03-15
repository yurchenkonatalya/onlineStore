import React from "react";
import style from "../../../style/SendButton.module.css"

import { Button } from "react-bootstrap";

const SendButton = ({onClick, children}) =>{


return(
<Button variant="success" className={style.btnSend} onClick={onClick}>{children}</Button>
)

}


export default SendButton