package br.com.chapecosolucoes.trafegusweb.client.components.wait
{
    import flash.display.DisplayObject;

    import mx.core.Application;
    import mx.core.FlexGlobals;
    import mx.managers.PopUpManager;

    public class Wait
    {
        private const TITULO:String = "PROCESSANDO...";

        private const MENSAGEM:String = "Isso pode levar alguns segundos.";

        private static var instance:Wait = null;

        private var _Form:WaitForm

        private var acesso:int = 0;

        public function Wait(forca:Forca)
        {
            _Form = new WaitForm();
        }

        public static function getInstance():Wait
        {
            if (instance == null)
            {
                instance = new Wait(new Forca());
            }
            return instance;
        }

        public function Show(mensagem:String = MENSAGEM, titulo:String = TITULO, show_spinner:Boolean = true):void
        {
            acesso++;
            this._Form.Show_spinner = show_spinner
            this._Form.Titulo = titulo;
            this._Form.Mensagem = mensagem;
            PopUpManager.removePopUp(this._Form);
            PopUpManager.addPopUp(this._Form, DisplayObject(FlexGlobals.topLevelApplication), true)
            PopUpManager.centerPopUp(this._Form);
            this._Form.visible = true;
            this._Form.spinner.play();
        }

        public function Close():void
        {
            acesso--;
            if (acesso == 0)
            {
                this._Form.spinner.stop();
                this._Form.visible = false;
                PopUpManager.removePopUp(this._Form);
            }
        }
    }
}

class Forca
{
}