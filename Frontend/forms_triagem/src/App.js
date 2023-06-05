import './App.css';
import React from 'react';
import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router } from 'react-router-dom';
import SignupForm from '../src/FormCadastro';
import ReactDOM from 'react-dom';

function App() {
  ReactDOM.render(
    <Router>
    <SignupForm />
  </Router>, document.getElementById('root')
  );
  
}

export default App;
