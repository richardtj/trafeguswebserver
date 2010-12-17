package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.ClassesReferenciaView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ClassesReferenciaVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.collections.XMLListCollection;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;

	public class ClassesReferenciaController
	{
		public function ClassesReferenciaController()
		{
		}
		public var view:ClassesReferenciaView;
		public function solicitaClassesReferencias():void
		{
			TrafegusWS.getIntance().solicitaClassesReferencias(solicitaClassesReferenciasResultHandler);
		}
		public function classesReferenciaFilterFunction(item:Object):Boolean
		{
			return (String(ClassesReferenciaVO(item).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		private function solicitaClassesReferenciasResultHandler(event:ResultEvent):void{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().classesReferencia.removeAll();
			for each (var obj:Object in resultArray)
			{
				var referencia:ClassesReferenciaVO = new ClassesReferenciaVO();
				referencia.setClassesReferenciaVO(obj);
				MainModel.getInstance().classesReferencia.addItem(referencia);
			}
		}
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);
		}
		public function classesReferenciaSelecionadas():void
		{
			for each (var classe:ClassesReferenciaVO in MainModel.getInstance().classesReferencia)
			{
				TrafegusWS.getIntance().solicitaRefencias(solicitaRefenciasResultHandler,classe.codigo);
			}
		}
		private function solicitaRefenciasResultHandler(event:ResultEvent):void
		{
			
		}
	}
}