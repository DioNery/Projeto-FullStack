import React, { useState } from 'react';
import axios from 'axios';
import '../../src/index.css';
import Img from '../../src/assets/TriaGeral1.png';
import { useNavigate } from 'react-router-dom';

function Cadastro() {
  const navigate = useNavigate();
  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [error, setError] = useState('');
  const [submitted, setSubmitted] = useState(false);
  const [nomeSalvo, setNomeSalvo] = useState(''); // Estado para armazenar o valor do nome

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (nome.trim() !== '' && email.trim() !== '' && senha.trim() !== '') {
      let data = {
        nome,
        email,
        senha
      };

      try {
        const response = await axios.post('http://localhost:8080/api/v1/Usuarios', data);
        console.log('Usuário adicionado:', response.data);
        setNomeSalvo(nome); // Atualiza o estado do nomeSalvo com o valor do nome
        setSubmitted(true);
        handleClearInputs();
      } catch (error) {
        if (error.response) {
          console.error('Erro ao adicionar usuário:', error.response.data);
          setError('Erro ao adicionar usuário. Detalhes do erro: ' + error.response.data);
        } else if (error.request) {
          console.error('Erro de conexão com o servidor:', error.request);
          setError('Erro de conexão com o servidor. Verifique sua conexão de internet.');
        } else {
          console.error('Erro ao adicionar usuário:', error.message);
          setError('Ocorreu um erro ao adicionar o usuário. Detalhes do erro: ' + error.message);
        }
      }
    } else {
      setError('Por favor, preencha todos os campos obrigatórios!');
    }
  };

  const handleClearInputs = () => {
    setNome('');
    setEmail('');
    setSenha('');
    setError('');
  };

  if (submitted) {
    return (
      <div>
        <img src={Img} alt="logo" className="Img" />
        <br />
        <div>
          <h1>Bem vindo a Triagem,</h1>
          <h1 style={{ color: 'black' }}>{nomeSalvo}</h1> {/* Exibe o valor do nomeSalvo */}
        </div>

        <br />
        <a href="http://localhost:5173/triagem">
          <button>Para a Triagem</button>
        </a>
        <a href="http://localhost:5173/contato">
          <button>Contato</button>
        </a>
      </div>
    );
  } else {
    return (
      <div className="cadastro-container">
        <h2>Cadastro</h2>
        {error && <p className="error">{error}</p>}
        <form onSubmit={handleSubmit}>
          <div>
            <label htmlFor="nome">Nome:</label>
            <input
              type="text"
              id="nome"
              value={nome}
              onChange={(e) => setNome(e.target.value)}
            />
          </div>
          <div>
            <label htmlFor="email">Email:</label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>
          <div>
            <label htmlFor="senha">Senha:</label>
            <input
              type="password"
              id="senha"
              value={senha}
              onChange={(e) => setSenha(e.target.value)}
            />
          </div>
          <button type="submit">Enviar</button>
        </form>
      </div>
    );
  }
}

export default Cadastro;
