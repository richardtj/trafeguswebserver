package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.MotoristaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.SelectedDriverEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
	import br.com.chapecosolucoes.trafegusweb.client.view.DriverDetails;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DadosMotoristaVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.MotoristaVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.events.MouseEvent;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;

	public class MotoristaZoomController
	{
		public function MotoristaZoomController()
		{
		}
		public var view:MotoristaZoom;
		public function motoristaSelecionado():void
		{
			if (this.view.grid.selectedItem != null)
			{
				var motoristaEvent:SelectedDriverEvent = new SelectedDriverEvent(SelectedDriverEvent.SELECTED_DRIVER_EVENT,MotoristaVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(motoristaEvent);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhum motorista selecionado.");
			}
		}
		public function motoristaFilterFunction(item:Object):Boolean
		{
			return (String(DadosMotoristaVO(item).codigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DadosMotoristaVO(item).categoriaCNH).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DadosMotoristaVO(item).codigoCNH).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DadosMotoristaVO(item).cpfMotoristaPrincipal).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DadosMotoristaVO(item).dataCadastro).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DadosMotoristaVO(item).motoristaPrincipal).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DadosMotoristaVO(item).numeroCNH).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DadosMotoristaVO(item).rg).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DadosMotoristaVO(item).sexo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DadosMotoristaVO(item).treinado).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DadosMotoristaVO(item).ultimoTreinamento).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DadosMotoristaVO(item).validadeCNH).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DadosMotoristaVO(item).validadePesquisa).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function solicitaListaMotoristas(event:PaginableEvent):void
		{
			TrafegusWS.getInstance().solicitaListaMotoristas(solicitaListaMotoristasResultHandler,event.paginaAtual);
		}
		public function atualizaListaMotoristas():void
		{
			this.view.paginable.paginaAtual = 1;
			this.solicitaTotalListaMotoristas();
			TrafegusWS.getInstance().solicitaListaMotoristas(solicitaListaMotoristasResultHandler,0);
		}
		private function solicitaListaMotoristasResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().motoristasArray.removeAll();
			var i:int = ((this.view.paginable.paginaAtual - 1) * MainModel.getInstance().itensPorPaginaVO.itensPorPagina) + 1;
			for each (var obj:Object in resultArray)
			{
				var motorista:DadosMotoristaVO = new DadosMotoristaVO();
				motorista.setDadosMotoristaVO(obj);
				motorista.count = i++;
				MainModel.getInstance().motoristasArray.addItem(motorista);
			}
		}
		public function closeHandler():void
		{
			if(this.view.paginable.paginaAtual != 1)
			{
				MainModel.getInstance().motoristasArray.removeAll();
			}
			MyPopUpManager.removePopUp(this.view);
		}
		public function solicitaTotalListaMotoristas():void
		{
			TrafegusWS.getInstance().solicitaTotalListaMotoristas(solicitaTotalListaMotoristasResultHandler);
		}
		private function solicitaTotalListaMotoristasResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().totalListaMotoristas = int(obj.total.toString());
			}
		}
		public function selectedDriverEventHandler(event:SelectedDriverEvent):void
		{
			event.stopImmediatePropagation();
			this.motoristaSelecionado();
		}
		public function mouseOverEventHandler():void
		{
			DriverDetails.SELECT_BUTTON_VISIBLE = true;
		}
		public function advancedSearchMotoristasEventHandler(event:AdvancedSearchEvent):void
		{
			TrafegusWS.getInstance().procuraMotoristas(procuraMotoristasResultHandler,event.genericVO);
		}
		private function procuraMotoristasResultHandler(event:ResultEvent):void
		{
			MainModel.getInstance().totalListaMotoristas = 1;
			this.solicitaListaMotoristasResultHandler(event);
		}
	}
}