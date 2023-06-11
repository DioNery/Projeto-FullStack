import React from 'react';
import Img from '../../src/assets/TriaGeral1.png';
import '../../src/index.css'

function App() {
  
  return (
    
    <div>
       
      <img src={Img} alt='logo' className='Img' /><br/>
      <h1>Bem vindo a Triagem</h1><br/>
      <a href="http://localhost:5173/triagem">
        <button>Para a Triagem</button>
      </a>
      <a href="http://localhost:5173/cadastro">
        <button>Realizar Cadastro</button>
      </a>
      <a href="http://localhost:5173/medicos">
        <button>Médicos disponíveis</button>
      </a>
      
    </div>
    
  );
}

export default App;
