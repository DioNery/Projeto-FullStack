import React, { Component } from 'react'
import UsuarioService from '../services/UsuarioService';

class CreateUsuarioComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            nome: '',
            email: '',
            senha: ''
        }
        this.changeNomeHandler = this.changeNomeNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.saveOrUpdateUsuario = this.saveOrUpdateUsuario.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            UsuarioService.getUsuarioById(this.state.id).then( (res) =>{
                let usuario = res.data;
                this.setState({nome: usuario.nome,
                    email: usuario.email,
                    senha : usuario.senha
                });
            });
        }        
    }
    saveOrUpdateEmployee = (e) => {
        e.preventDefault();
        let usuario = {nome: this.state.nome, email: this.state.email, emailId: this.state.emailId};
        console.log('usuario => ' + JSON.stringify(usuario));

        // step 5
        if(this.state.id === '_add'){
            UsuarioService.createUsuario(usuario).then(res =>{
                this.props.history.push('/Usuarios');
            });
        }else{
            UsuarioService.updateUsuario(usuario, this.state.id).then( res => {
                this.props.history.push('/Usuarios');
            });
        }
    }
    
    changeNomeHandler= (event) => {
        this.setState({nome: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({email: event.target.value});
    }

    changeSenhaHandler= (event) => {
        this.setState({senha: event.target.value});
    }

    cancel(){
        this.props.history.push('/Usuarios');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Usuario</h3>
        }else{
            return <h3 className="text-center">Update Usuario</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Nome: </label>
                                            <input placeholder="Nome" name="nome" className="form-control" 
                                                value={this.state.nome} onChange={this.changeNomeHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Email: </label>
                                            <input placeholder="Email" name="email" className="form-control" 
                                              type= "email"  value={this.state.email} onChange={this.changeEmailHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Senha: </label>
                                            <input placeholder="Senha" name="senha" className="form-control" 
                                              type="password"  value={this.state.senha} onChange={this.changeSenhaHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUsuario}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default CreateUsuarioComponent