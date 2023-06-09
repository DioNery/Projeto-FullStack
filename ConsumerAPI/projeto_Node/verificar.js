
const axios = require('axios');
async function verUsuarios()
  {
    const id = 1;
    const response = await axios.get(`http://localhost:8080/api/v1/Usuarios`);
    console.log('Usuários : ', response.data);
  }
  verUsuarios()