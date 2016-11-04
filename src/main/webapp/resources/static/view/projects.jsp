    <div> <!-- /.col-lg-12 -->
    					<!-- /.panel -->
                        <div class="panel panel-default">
                        <div class="panel-heading">
                            DataTables Advanced Tables
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                    	<!-- <th>id</th> -->
                                        <th>Code</th>
                                        <th>Name</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tr ng-repeat="p in ctrl.projects">
								 <td><span ng-bind="p.code"></span></td>
                              <td><span ng-bind="p.description"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(p.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(p.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          	</tr>
                      		</tbody>
                            </table>
                            <!-- /.table-responsive -->
                		</div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->