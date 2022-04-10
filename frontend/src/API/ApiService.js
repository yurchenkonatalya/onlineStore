import axios from "axios";
import Const from "../const/Const";

export default class ApiService{
   

    static registration = async (email, password, repeatPassword, phoneNumber) => {
        const response =  axios.post(Const.BACKEND + "/api/users/registration",
        {
            "email": email,
            "password": password,
            "repeatPassword": repeatPassword,
            "phoneNumber": phoneNumber
        })
        return response;
    }

    static login = async (email, password) => {
        const response =  axios.post(Const.BACKEND + "/api/users/login",
        {
            "email": email,
            "password": password,
        })
        return response;
    }

    static googleLogin = async (accessToken) => {
        console.log(Const.BACKEND)
        const response =  axios.post(Const.BACKEND + "/api/users/login/google",
        {
            "access_token": accessToken,
        })
        return response;
    }
    
}