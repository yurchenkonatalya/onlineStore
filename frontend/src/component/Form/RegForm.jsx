import React,{useEffect, useState} from "react";
import style from '../../style/Input.module.css'
import Input from "../UI/Input/Input";
import SendButton from "../UI/Button/SendButton";
import PhoneInput from "react-phone-input-2";
import axios from "axios";
import SuccessAlert from "../SuccessAlert";

const RegForm = () =>{

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [repeatPassword, setRepeatPassword] = useState('')
    const [phoneNumber, seetPhoneNumber] = useState('')

    const [successAlert, setSuccessAlert] = useState(false)

    useEffect(() => {
        if(successAlert){
            setTimeout(() => {
                setSuccessAlert(false)
            }, 10000)
        }
    }, [successAlert])

    const sendRegistration = () =>{
        axios.post("http://localhost:8100/api/users/registration",
        {
            "email": email,
            "password": password,
            "repeatPassword": repeatPassword,
            "phoneNumber": phoneNumber
        }
        ).then(resp =>{
            const result = resp.data.isSuccess;
            if(result){
                setSuccessAlert(true)
            }
        })
    }

  
return (
 <div>
 
    <form autoComplete="off">
<blockquote className={[style.label, "blockquote"].join(' ')}>


Регистрация
</blockquote>
      <Input placeholder="email" callback = {setEmail}/>
      <Input placeholder="password" callback = {setPassword}/>
      <Input placeholder="repeat password" callback = {setRepeatPassword}/>

      <PhoneInput
      country={"by"}
      countryCodeEditable={false}
      specialLabel={""}
      onChange={e => seetPhoneNumber(e)}
      />
      <SendButton sendDataCallback={sendRegistration}>Зарегистрироваться</SendButton>
    
      </form>
      {
    successAlert ? (<SuccessAlert></SuccessAlert>) : ""
 }
      </div>

)
}

export default RegForm;