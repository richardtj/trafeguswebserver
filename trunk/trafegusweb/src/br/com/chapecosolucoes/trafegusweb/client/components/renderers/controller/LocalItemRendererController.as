package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.LocalItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.view.LocalDetailsView;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;

	public class LocalItemRendererController
	{
		public function LocalItemRendererController()
		{
		}
		public var view:LocalItemRendererView;
		public function popUp(codigo:String):void
		{
			var localDetails:LocalDetailsView = new LocalDetailsView();
			localDetails.codigo = codigo;
			PopUpManager.addPopUp(localDetails,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(localDetails);
		}
	}
}