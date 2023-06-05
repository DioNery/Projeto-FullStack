import React, { useState } from 'react';
import axios from 'axios';
import { useHistory } from 'react-router-dom';
import '../src/css/SignupForm.css';
import OutraPagina from './OutraPagina';

const SignupForm = () => {
  const [formData, setFormData] = useState({
    nome: '',
    senha: ''
  });

  const history = useHistory();

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
  
    try {
      const response = await axios.post('/api/submit-form', formData);
      console.log(response.data);
      // Realize ações adicionais com a resposta do backend, se necessário
    } catch (error) {
      console.error(error);
      // Trate os erros de requisição, se houver
    }
    history.push("/OutraPagina", { formData });
  };

  return (
    <Switch>
    <form onSubmit={handleSubmit} method='POST' action='/api/submit-form' className='signup-form'>
      <input
        type="text"
        name="nome"
        value={formData.nome}
        onChange={handleInputChange}
      />
      <input
        type="password"
        name="senha"
        value={formData.senha}
        onChange={handleInputChange}
      />
      <button type="submit">Enviar</button>
    </form>
    
    <Route path="/OutraPagina" component={OutraPagina} />
  </Switch>
  );
};

export default SignupForm;
