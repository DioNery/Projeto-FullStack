import React, { useState } from 'react';
import Checkbox from '@mui/material/Checkbox';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import '../../src/index.css';

function Home() {
  const [isCheckedDorDeCabeca, setIsCheckedDorDeCabeca] = useState(false);
  const [isCheckedVomito, setIsCheckedVomito] = useState(false);
  const [isCheckedDiarreia, setIsCheckedDiarreia] = useState(false);
  const [isCheckedTontura, setisCheckedTontura] = useState(false);
  const [isCheckedSangramento, setisCheckedSangramento] = useState(false);

  const handleCheckboxChange1 = (event) => {
    setIsCheckedDorDeCabeca(event.target.checked);
  };

  const handleCheckboxChange2 = (event) => {
    setIsCheckedVomito(event.target.checked);
  };

  const handleCheckboxChange3 = (event) => {
    setIsCheckedDiarreia(event.target.checked);
  };

  const handleCheckboxChange4 = (event) => {
    setisCheckedTontura(event.target.checked);
  };

  const handleCheckboxChange5 = (event) => {
    setisCheckedSangramento(event.target.checked);
  };

  const desselecionarTudo = () => {
    setIsCheckedDorDeCabeca(false);
    setIsCheckedVomito(false);
    setIsCheckedDiarreia(false);
    setisCheckedTontura(false);
    setisCheckedSangramento(false);
  };

  const handleFormSubmit = () => {
    if (isCheckedDorDeCabeca && isCheckedVomito && isCheckedDiarreia && isCheckedTontura && isCheckedSangramento) {
      alert('Sua situação é de EXTREMA EMERGÊNCIA!! Recomenda-se o Hospital da Restauração Gorvenador Paulo Guerra.');
      
    } else if (isCheckedDorDeCabeca && isCheckedVomito) {
      alert('Sua situação é de Pouca Urgência . Recomenda-se o Hospital das Clínicas.');
    } 
    else if(isCheckedTontura && isCheckedSangramento)
    {
        alert('Sua situação é de Muita Urgência . Recomenda-se o Hospital da Restauração');
    }
    else if(isCheckedDiarreia && isCheckedSangramento)
    {
        alert('Sua situação é de Muita Urgência . Recomenda-se o Hospital Universitário Oswaldo Cruz.');
    }
    else if(isCheckedDiarreia && isCheckedTontura)
    {
        alert('Sua situação é de Urgência . Recomenda-se o Hospital Universitário Oswaldo Cruz.');
    }
    else if(isCheckedDiarreia)
    {
        alert('Sua situação é de Pouca Urgência . Recomenda-se o Hospital Universitário Oswaldo Cruz.');
    }
    else if(isCheckedTontura)
    {
        alert('Sua situação é de Pouca Urgência . Recomenda-se o Hospital das Clínicas.');
    }
    else if(isCheckedVomito)
    {
        alert('Sua situação é de Pouca Urgência . Recomenda-se o Hospital das Clínicas ');
    }
    else if(isCheckedSangramento)
    {
      alert('Sua situação é de Urgência . Recomenda-se o Hospital da Restauração');
    }
    else if (isCheckedDorDeCabeca) {
      alert('Sua situação é de não Urgente. Recomenda-se a UPA 24 horas mais próxima da sua casa.');
    }
    else{
      alert('Por favor selecione alguma das opções!');
    }
    desselecionarTudo();
  };

  return (
    <div>
      <h1>Inicio da triagem</h1>
      <p>Adicione os sintomas</p>
      <FormGroup>
        <FormControlLabel
          control={
            <Checkbox
              checked={isCheckedDorDeCabeca}
              onChange={handleCheckboxChange1}
              defaultChecked={false}
            />
          }
          label="Dor de cabeça"
          className='FormSintoma'
        />
        <FormControlLabel
          control={
            <Checkbox
              checked={isCheckedVomito}
              onChange={handleCheckboxChange2}
              defaultChecked={false}
            />
          }
          label="Vômito"
          className='FormSintoma'
        />
        <FormControlLabel
          control={
            <Checkbox
              checked={isCheckedDiarreia}
              onChange={handleCheckboxChange3}
              defaultChecked={false}
            />
          }
          label="Diarreia"
          className='FormSintoma'
        />
        <FormControlLabel
          control={
            <Checkbox
              checked={isCheckedTontura}
              onChange={handleCheckboxChange4}
              defaultChecked={false}
            />
          }
          label="Tontura"
          className='FormSintoma'
        />
        <FormControlLabel
          control={
            <Checkbox
              checked={isCheckedSangramento}
              onChange={handleCheckboxChange5}
              defaultChecked={false}
            />
          }
          label="Sangramento externo"
          className='FormSintoma'
        />
      </FormGroup>
      <button onClick={handleFormSubmit}>Enviar</button>
    </div>
  );
}

export default Home;
