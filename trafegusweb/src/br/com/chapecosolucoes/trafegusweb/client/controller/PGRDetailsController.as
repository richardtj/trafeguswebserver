package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.PGRDetails;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DadosPGRVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.XMLListCollection;
	import mx.rpc.events.ResultEvent;

	public class PGRDetailsController
	{
		public function PGRDetailsController()
		{
		}
		public var view:PGRDetails;
		public function solicitaDadosPGR(codigo:String):void
		{
			TrafegusWS.getIntance().solicitaDadosPGR(solicitaDadosPGRResultHandler,codigo);
		}
		private function solicitaDadosPGRResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().dadosPGRVO.setDadosPGRVO(obj);
			}
		}
	}
}