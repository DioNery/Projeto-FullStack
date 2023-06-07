import axios from 'axios';

const USUARIO_API_BASE_URL = "http://localhost:8080/api/v1/Usuarios";

class UsuarioService {

    getUsuarios(){
        return axios.get(USUARIO_API_BASE_URL);
    }
    //CREATE
    createUsuario(usuario){
        return axios.post(USUARIO_API_BASE_URL, usuario);
    }
    //READ
    getUsuarioById(usuarioId){
        return axios.get(USUARIO_API_BASE_URL + '/' + usuarioId);
    }
    //UPDATE
    updateUsuario(usuario, usuarioId){
        return axios.put(USUARIO_API_BASE_URL + '/' + usuarioId, usuario);
    }
    //DELETE
    deleteUsuario(usuarioId){
        return axios.delete(USUARIO_API_BASE_URL + '/' + usuarioId);
    }
}

export default new UsuarioService()
