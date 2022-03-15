import React from "react";
import style from '../../style/Modal.module.css'

const Modal = ({children,  visible, setVisible}) =>{
    const rootClasses = [style.main]

    if(visible){
        rootClasses.push(style.active)
    }

return <div className={rootClasses.join(' ')} onClick={() => setVisible(false)}>
            <div className={style.context} onClick={(e) => e.stopPropagation()}>
                {children}
             </div>
    </div>
}

export default Modal;