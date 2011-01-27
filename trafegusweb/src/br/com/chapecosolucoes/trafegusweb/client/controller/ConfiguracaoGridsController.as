package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller.BaseZoomController;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ItensPorPaginaVO;
	
	public class ConfiguracaoGridsController extends BaseZoomController
	{
		public function ConfiguracaoGridsController()
		{
			super();
		}
		public function salvar():void
		{
			MainModel.getInstance().itensPorPaginaVO.itensPorPagina = int(this.view.itensPorPagina.value);
			this.closeHandler();
		}
	}
}