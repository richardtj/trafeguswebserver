package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.TransportadorDetails;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.XMLListCollection;
	import mx.rpc.events.ResultEvent;

	public class TransportadorDetailsController
	{
		public function TransportadorDetailsController()
		{
		}
		public var view:TransportadorDetails;
		public function solicitaDadosTransportador(param:String):void
		{
			TrafegusWS.getIntance().solicitaDadosTransportador(solicitaDadosTransportadorResultHandler,param);
		}
		private function solicitaDadosTransportadorResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().dadosTransportadorVO.setDadosTransportadorVO(obj);
			}
		}
	}
}