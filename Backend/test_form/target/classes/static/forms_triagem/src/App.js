import './App.css';
import React from 'react';
import SignupForm from '../src/FormCadastro';
import ReactDOM from 'react-dom';


function App() {
  ReactDOM.render(<SignupForm />, document.getElementById('root'));
  
}

export default App;
