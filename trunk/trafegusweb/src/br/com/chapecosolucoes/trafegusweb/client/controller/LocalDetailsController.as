package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.LocalDetailsView;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.XMLListCollection;
	import mx.rpc.events.ResultEvent;

	public class LocalDetailsController
	{
		public function LocalDetailsController()
		{
		}
		public var view:LocalDetailsView;
		public function solicitaDadosLocal(codigo:String):void
		{
			TrafegusWS.getIntance().solicitaDadosLocal(solicitaDadosLocalResultHandler,codigo);
		}
		private function solicitaDadosLocalResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().dadosLocalVO.setDadosLocalVO(obj);
			}
		}
	}
}