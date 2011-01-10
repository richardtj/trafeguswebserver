package br.com.chapecosolucoes.trafegusweb.client.components.wait
{
    import flash.display.DisplayObject;
    
    import mx.core.Application;
    import mx.core.FlexGlobals;
    import mx.managers.PopUpManager;
    import mx.managers.PopUpManagerChildList;

    public class Wait
    {
        private static var instance:Wait = null;

		private var spinner:Spinner;

        private var acesso:int = 0;

        public function Wait(forca:Forca)
        {
			spinner = new Spinner();
        }

        public static function getInstance():Wait
        {
            if (instance == null)
            {
                instance = new Wait(new Forca());
            }
            return instance;
        }

        public function Show(show_spinner:Boolean = true):void
        {
            acesso++;
			if(acesso == 1)
			{
	            PopUpManager.addPopUp(this.spinner, DisplayObject(FlexGlobals.topLevelApplication), true, PopUpManagerChildList.POPUP)
	            PopUpManager.centerPopUp(this.spinner);
				this.spinner.visible = true;
				this.spinner.play();
			}
        }

        public function Close():void
        {
            acesso--;
            if (acesso == 0)
            {
				this.spinner.stop();
				this.spinner.visible = false;
	            PopUpManager.removePopUp(this.spinner);
            }
        }
    }
}

class Forca
{
}