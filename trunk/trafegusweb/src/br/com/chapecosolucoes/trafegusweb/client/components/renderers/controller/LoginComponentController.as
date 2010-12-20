package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
    import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.LoginComponent;
    import br.com.chapecosolucoes.trafegusweb.client.events.LoginEvent;
    import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
    import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
    import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
    
    import mx.collections.XMLListCollection;
    import mx.controls.Alert;
    import mx.rpc.events.ResultEvent;

    public class LoginComponentController
    {
        public function LoginComponentController()
        {
        }

        public var view:LoginComponent;

        public function loginHandler(userName:String, passWord:String):void
        {
            TrafegusWS.getIntance().solicitaAcesso(solicitaAcessoHandler, userName, passWord);
        }

        private function solicitaAcessoHandler(evt:ResultEvent):void
        {
            var resultArray:Array = ParserResult.parserDefault(evt);
            for each (var obj:Object in resultArray)
            {
                MainModel.getInstance().codEmpresa = obj.usua_pess_oras_codigo.toString();
                MainModel.getInstance().codUsuario = obj.usua_pfis_pess_oras_codigo.toString();
            }
            if (resultArray.length != 0)
            {
                this.view.textinput1.text = "";
                this.view.textinput2.text = "";
                var loginEvent:LoginEvent = new LoginEvent(LoginEvent.LOGIN_EVENT, true);
                this.view.dispatchEvent(loginEvent);
            }
            else
            {
                Alert.show("Usuario ou senha inválidos.");
            }
        }
    }
}