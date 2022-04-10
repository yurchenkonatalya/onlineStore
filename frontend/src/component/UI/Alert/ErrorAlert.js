import React from "react";
import style from "./Alert.module.css"

const ErrorAlert = ({...props}) =>{
  
return <div  className={[style.alert, "alert", "alert-danger"].join(' ')} role="alert" {...props}>
Ошибка при обращении к серверу
</div>
}

export default ErrorAlert;