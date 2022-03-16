import React,{useState} from "react";
import style from "../../../style/Input.module.css"

const Input = ({callback, placeholder}) =>{

return(
    <input type="email" className={[style.input, "form-control"].join(' ')} 
    placeholder={placeholder} autoComplete="off" onChange={e => callback(e.currentTarget.value)}/>
)

}


export default Input