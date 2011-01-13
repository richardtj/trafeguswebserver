package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.SMGrid;
	import br.com.chapecosolucoes.trafegusweb.client.vo.SMVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import mx.controls.Alert;
	import mx.rpc.events.ResultEvent;

	public class SMGridController
	{
		public function SMGridController()
		{
		}
		public var view:SMGrid;
		public function solicitaSMVeiculo(placaVeiculo:String):void
		{
			TrafegusWS.getIntance().solicitaSMVeiculo(solicitaSMVeiculoResultHandler,placaVeiculo);
		}
		private function solicitaSMVeiculoResultHandler(event:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(event);
			MainModel.getInstance().smArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var smvo:SMVO = new SMVO();
				smvo.setSMVO(obj);
				MainModel.getInstance().smArray.addItem(smvo);
			}
		}
		public function editarSM():void
		{
			if(this.view.grid.selectedIndex == -1)
			{
				MessageBox.informacao("Nenhuma SM Selecionada");
			}
			else
			{
				
			}
		}
		public function atualizaListaSM():void
		{
			
		}
		public function smFilterFunction(item:Object):Boolean{
			return (String(SMVO(item).dataCadastro).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(SMVO(item).destino).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(SMVO(item).embarcador).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(SMVO(item).numeroViagem).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(SMVO(item).operacao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(SMVO(item).origem).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(SMVO(item).placa).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(SMVO(item).prevFim).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(SMVO(item).prevInicio).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(SMVO(item).terminal).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(SMVO(item).transportador).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function numeroViagemLabelFunction(data:Object):String
		{
			return "";
		}
	}
}