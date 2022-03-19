import axios from "axios";

export default class ApiService{
    static backend = "http://localhost:8100";

    static registration = async (email, password, repeatPassword, phoneNumber) => {
        const response =  axios.post("http://localhost:8100/api/users/registration",
        {
            "email": email,
            "password": password,
            "repeatPassword": repeatPassword,
            "phoneNumber": phoneNumber
        })
        return response;
    }
    
}