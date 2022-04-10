import React from "react";
import style from "./Loader.module.css"

const Loader = ({...props}) =>{

return(
<div className={[style.loader,"spinner-border"].join(' ')} role="status" {...props}>
</div>
)

}


export default Loader