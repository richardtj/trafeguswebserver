package br.com.chapecosolucoes.trafegusweb.client.components.custom
{
    import br.com.chapecosolucoes.trafegusweb.client.model.GridConfig;
    import br.com.chapecosolucoes.trafegusweb.client.vo.grids.Grid;
    
    import mx.controls.DataGrid;
    import mx.controls.dataGridClasses.DataGridColumn;
    import mx.core.mx_internal;
    import mx.events.FlexEvent;

    public class ChpTitleWindow extends mx.containers.TitleWindow
    {
        public function ChpTitleWindow()
        {
            addEventListener(FlexEvent.CREATION_COMPLETE, onCreateCompleteHander);
        }

        private function onCreateCompleteHander(e:FlexEvent):void
        {
            var ch:Array = this.getChildren();
            var nomeGrid:String = "";
            var grid:Grid = null;
            var col:Array = null;
            for (var i:int = 0; i < ch.length; i++)
            {
                if (this.getChildAt(i) is DataGrid)
                {
                    nomeGrid = this.id + DataGrid(this.getChildAt(i)).id;
                    col = DataGrid(this.getChildAt(i)).columns;
                    grid = GridConfig.getInstance().createGrid(nome);
                    for (var u:int = 0; i < col.length; u++)
                    {
                        grid.addColuna(DataGridColumn(col[u]).dataField, u, DataGridColumn(col[u]).width, DataGridColumn(col[u]).visible);
                    }
					GridConfig.getInstance().addGrid(grid);
                }
            }

        }

    }
}