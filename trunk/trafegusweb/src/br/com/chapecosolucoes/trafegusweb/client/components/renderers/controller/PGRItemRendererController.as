package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.PGRItemRendererView;
	import br.com.chapecosolucoes.trafegusweb.client.view.PGRDetails;
	
	import flash.display.DisplayObject;
	
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;

	public class PGRItemRendererController
	{
		public function PGRItemRendererController()
		{
		}
		public var view:PGRItemRendererView;
		public function popUp(codigo:String):void
		{
			var pgrDetails:PGRDetails = new PGRDetails();
			pgrDetails.codigo = codigo;
			PopUpManager.addPopUp(pgrDetails,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(pgrDetails);
		}
	}
}