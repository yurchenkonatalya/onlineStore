import React from "react";
import style from '../../style/Input.module.css'
import Input from "../UI/Input/Input";
import SendButton from "../UI/Button/SendButton";
import PhoneInput from "react-phone-input-2";

const RegForm = () =>{
  
return (
    <form autoComplete="off">
<blockquote className={[style.label, "blockquote"].join(' ')}>

Регистрация
</blockquote>
      <Input placeholder="email"/>
      <Input placeholder="password"/>
      <Input placeholder="repeat password"/>

      <PhoneInput
      country={"by"}
      countryCodeEditable={false}
      specialLabel={""}
      />
      <SendButton>Зарегистрироваться</SendButton>
    
      </form>

)
}

export default RegForm;