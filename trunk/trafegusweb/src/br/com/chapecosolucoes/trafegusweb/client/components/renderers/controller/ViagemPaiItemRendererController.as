package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.ViagemPaiItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.view.ViagemPaiDetails;
	
	import flash.display.DisplayObject;
	import flash.events.MouseEvent;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;

	public class ViagemPaiItemRendererController
	{
		public function ViagemPaiItemRendererController()
		{
		}
		public var view:ViagemPaiItemRendererView;
		public function popUp():void
		{
			var viagemPaiDetails:ViagemPaiDetails = new ViagemPaiDetails();
			PopUpManager.addPopUp(viagemPaiDetails,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(viagemPaiDetails);
		}
	}
}