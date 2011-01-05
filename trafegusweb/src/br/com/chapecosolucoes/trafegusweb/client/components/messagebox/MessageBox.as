package br.com.chapecosolucoes.trafegusweb.client.components.messagebox
{
    import flash.display.Sprite;
    
    import mx.controls.Alert;
    import mx.effects.Dissolve;
    import mx.effects.Iris;

    public class MessageBox
    {

        [Bindable]
        [Embed(source='./assets/error.png')]
        private static var erroIcone:Class;

        [Bindable]
        [Embed(source='./assets/information.png')]
        private static var inforIcone:Class;

        [Bindable]
        [Embed(source='./assets/warning.png')]
        private static var alertaIcone:Class;

        [Bindable]
        [Embed(source='./assets/question.png')]
        private static var perguntaIcone:Class;

        public static const YES:uint = Alert.YES;

        public static const NO:uint = Alert.NO;
		
		private static var dissolve:Dissolve = new Dissolve();
		
		private static var iris:Iris = new Iris();


        public function MessageBox()
        {
			dissolve.duration = 700;
			iris.duration = 700;
        }

        public static function atencao(text:String = "", title:String = "", flags:uint = 0x4, parent:Sprite = null, closeHandler:Function = null, iconClass:Class = null, defaultButtonFlag:uint = 0x4):Alert
        {
            title = (title != "" ? "Atenção - " + title : "Atenção");
			var alert:Alert = Alert.show(text, title, flags, parent, closeHandler, iconClass, defaultButtonFlag);
			alert.titleIcon = alertaIcone;
			alert.setStyle("creationCompleteEffect", dissolve);
			alert.setStyle("creationCompleteEffect", iris);
			alert.setStyle("removedEffect", dissolve);
			alert.setStyle("removedEffect", iris);
			return alert;
        }

        public static function informacao(text:String = "", title:String = "", flags:uint = 0x4, parent:Sprite = null, closeHandler:Function = null, iconClass:Class = null, defaultButtonFlag:uint = 0x4):Alert
        {
            title = (title != "" ? "Informação - " + title : "Informação");
            var alert:Alert = Alert.show(text, title, flags, parent, closeHandler, iconClass, defaultButtonFlag);
            alert.titleIcon = inforIcone;
			alert.setStyle("creationCompleteEffect", dissolve);
			alert.setStyle("creationCompleteEffect", iris);
			alert.setStyle("removedEffect", dissolve);
			alert.setStyle("removedEffect", iris);
            return alert;
        }

        public static function erro(text:String = "", title:String = "", flags:uint = 0x4, parent:Sprite = null, closeHandler:Function = null, iconClass:Class = null, defaultButtonFlag:uint = 0x4):Alert
        {
            title = (title != "" ? "Erro - " + title : "Erro");
			var alert:Alert = Alert.show(text, title, flags, parent, closeHandler, iconClass, defaultButtonFlag);
			alert.titleIcon = erroIcone;
			alert.setStyle("creationCompleteEffect", dissolve);
			alert.setStyle("creationCompleteEffect", iris);
			alert.setStyle("removedEffect", dissolve);
			alert.setStyle("removedEffect", iris);
			return alert;
        }

        public static function pergunta(text:String = "", title:String = "", flags:uint = 0x4, parent:Sprite = null, closeHandler:Function = null, iconClass:Class = null, defaultButtonFlag:uint = 0x4):Alert
        {
            title = (title != "" ? "Pergunta - " + title : "Pergunta");
            if (flags == 0x4)
            {
                flags = Alert.YES | Alert.NO;
                if (defaultButtonFlag == 0x4)
                    defaultButtonFlag = Alert.NO;
            }
			var alert:Alert = Alert.show(text, title, flags, parent, closeHandler, iconClass, defaultButtonFlag);
			alert.titleIcon = perguntaIcone;
			alert.setStyle("creationCompleteEffect", dissolve);
			alert.setStyle("creationCompleteEffect", iris);
			alert.setStyle("removedEffect", dissolve);
			alert.setStyle("removedEffect", iris);
			return alert;
        }

    }
}