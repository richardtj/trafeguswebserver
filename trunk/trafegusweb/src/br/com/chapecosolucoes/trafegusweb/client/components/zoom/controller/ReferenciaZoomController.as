package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.advancedsearch.view.AdvancedSearchReferenciasImpl;
	import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.model.ReferenciaZoomModel;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.ReferenciaZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.AdvancedSearchEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.ReferenciaSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ClassesReferenciaVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO;
	
	import flash.display.DisplayObject;
	
	import mx.collections.ArrayCollection;
	import mx.core.FlexGlobals;
	import mx.core.IFlexDisplayObject;
	import mx.managers.PopUpManager;

	public class ReferenciaZoomController extends BaseZoomController
	{
		public var model:ReferenciaZoomModel;
		public function ReferenciaZoomController()
		{
		}
		public function atualizaReferenciasZoom():void
		{
			if(MainModel.getInstance().referencias.length == 0)
			{
				MessageBox.informacao("Nenhum referencia carregada no mapa.");
			}
			else
			{
				MainModel.getInstance().referenciasZoom = new ArrayCollection(MainModel.getInstance().referencias.source.slice(0,20));
				MainModel.getInstance().totalReferenciasZoom = MainModel.getInstance().referencias.length;
			}
		}
		public function referenciaSelecionada():void
		{
			if(ReferenciaZoom(this.view).list.selectedItem != null)
			{
				var event:ReferenciaSelecionadaEvent = new ReferenciaSelecionadaEvent(ReferenciaSelecionadaEvent.REFERENCIA_SELECIONADA_EVENT,ReferenciaVO(ReferenciaZoom(this.view).list.selectedItem));
				this.view.dispatchEvent(event);
				this.closeHandler();
			}
			else
			{
				MessageBox.informacao("Nenhuma referência selecionada.");
			}
		}
		public function referenciasFilterFunction(item:Object):Boolean
		{
			return (String(ReferenciaVO(item).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ReferenciaVO(item).refeDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function solicitaReferenciasZoom(event:PaginableEvent):void
		{
			MainModel.getInstance().referenciasZoom = new ArrayCollection(MainModel.getInstance().referencias.source.slice(event.paginaAtual,event.paginaAtual+20));
			MainModel.getInstance().referenciasZoom.filterFunction = this.referenciasFilterFunction;
		}
		public function advancedSearchClickEventHandler(event:AdvancedSearchEvent):void
		{
			var advancedSearchReferencias:AdvancedSearchReferenciasImpl = new AdvancedSearchReferenciasImpl();
			advancedSearchReferencias.addEventListener(AdvancedSearchEvent.ADVANCED_SEARCH_EVENT,advancedSearchEventHandler);
			MyPopUpManager.addPopUp(advancedSearchReferencias,DisplayObject(FlexGlobals.topLevelApplication));
			PopUpManager.centerPopUp(advancedSearchReferencias);
		}
		private function advancedSearchEventHandler(event:AdvancedSearchEvent):void
		{
			MainModel.getInstance().referenciasZoom.removeAll();
			for each(var referenciaVO:ReferenciaVO in MainModel.getInstance().referencias)
			{
				if(event.genericVO.refeDescricao != "" && event.genericVO.descricao == "")
				{
					if(referenciaVO.refeDescricao.toUpperCase().search(event.genericVO.refeDescricao.toUpperCase()) >= 0)
					{
						MainModel.getInstance().referenciasZoom.addItem(referenciaVO);
					}
				}
				else if(event.genericVO.refeDescricao == "" && event.genericVO.descricao != "")
				{
					if(referenciaVO.descricao.toUpperCase().search(event.genericVO.descricao.toUpperCase()) >= 0)
					{
						MainModel.getInstance().referenciasZoom.addItem(referenciaVO);
					}
				}
				else if(event.genericVO.refeDescricao == "" && event.genericVO.descricao == "")
				{
					MainModel.getInstance().referenciasZoom.addItem(referenciaVO);
				}
				else if(event.genericVO.refeDescricao != "" && event.genericVO.descricao != "")
				{
					if(referenciaVO.refeDescricao.toUpperCase().search(event.genericVO.refeDescricao.toUpperCase()) >= 0 && referenciaVO.descricao.toUpperCase().search(event.genericVO.descricao.toUpperCase()) >= 0)
					{
						MainModel.getInstance().referenciasZoom.addItem(referenciaVO);
					}
				}
				
			}
			MainModel.getInstance().totalReferenciasZoom = MainModel.getInstance().referenciasZoom.length;
		}
	}
}