import React from "react";

import { Button } from "react-bootstrap";

const ModalButton = ({onClick, children, clazz}) =>{


return(
<Button className={clazz} variant="primary" onClick={onClick}>{children}</Button>
)

}


export default ModalButton