// import cadastrar from './consumer';
const axios = require('axios');

// const usuarioData = {
//       nome: 'João',
//       email: 'joao@example.com',
//       senha: '1213123123'
//     };
    
async function verUsuarios()
  {
    // axios.post('http://localhost:8080/api/v1/Usuarios', cadastrar)
    // .then(response => {
    //   // Manipule a resposta da solicitação POST
    //   console.log('Usuário criado:', response.data);
    // });
    // const id = 1;
    const response = await axios.get(`http://localhost:8080/api/v1/Usuarios`);
    console.log('Usuários : ', response.data);
  }
  verUsuarios();
  console.log('Servidor Rodando');