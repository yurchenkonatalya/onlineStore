import { useState } from "react"

const  useShowModal = (initial) => {
    
    const [isVisible, setVisible] = useState(initial);

    const show = (isShow) =>{
        setVisible(isShow)
    }

    return{
        isVisible,
        show
    }

}

export default useShowModal