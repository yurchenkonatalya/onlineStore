import React from "react";
import style from "./Alert.module.css"

const SuccessAlert = ({...props}) =>{
  
return <div  className={[style.alert, "alert", "alert-success"].join(' ')} role="alert" {...props}>
Проверьте свою почту
</div>
}

export default SuccessAlert;