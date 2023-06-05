import React from 'react';
import { useLocation } from 'react-router-dom';

const OutraPagina = () => {
  const location = useLocation();
  const { formData } = location.state;

  return (
    <div>
      <h2>Dados do formulário:</h2>
      <p>Nome: {formData.nome}</p>
      <p>Senha: {formData.senha}</p>
    </div>
  );
};

export default OutraPagina;
