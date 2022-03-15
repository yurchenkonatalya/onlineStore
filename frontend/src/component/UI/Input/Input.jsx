import React from "react";
import style from "../../../style/Input.module.css"

const Input = (props) =>{


return(
    <input type="email" className={[style.input, "form-control"].join(' ')} placeholder={props.placeholder} autoComplete="off"/>
)

}


export default Input