package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.TransportadorItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.view.TransportadorDetails;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;

	public class TransportadorItemRendererController
	{
		public function TransportadorItemRendererController()
		{
		}
		public var view:TransportadorItemRendererView;
		public function popUp(param:String):void
		{
			var transportadorDetails:TransportadorDetails = new TransportadorDetails();
			transportadorDetails.codigo = param;
			PopUpManager.addPopUp(transportadorDetails,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(transportadorDetails);
		}
	}
}