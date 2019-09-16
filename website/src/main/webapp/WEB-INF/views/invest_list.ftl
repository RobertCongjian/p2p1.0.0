<#if pageResult.listData?size &gt; 0 >
	<#list pageResult.listData as data>
		<tr>
			<td>${data.createUser.username }</td>
			<td>${data.title}</td>
			<td class="text-info">${data.currentRate}%</td>
			<td class="text-info">${data.bidRequestAmount}</td>
			<td>${data.returnTypeDisplay}</td>
			<td>
				<div class="">
					${data.persent} %
				</div>
			</td>
			<td><a class="btn btn-danger btn-sm"
				href="${ctx}/borrow_info.do?id=${data.id}">查看</a></td>
		</tr>
	</#list>
	<script type="text/javascript">
		$(function(){
			//先将分页的内容先删了  之后再换成新的分页内容
			$("#page_container").empty().append($('<ul id="pagination" class="pagination"></ul>'));

			$("#pagination").twbsPagination({
				totalPages:${pageResult.totalPage},
				startPage:${pageResult.currentPage},
				initiateStartPageClick:false,
				onPageClick : function(event, page) {
					$("#currentPage").val(page);
					$("#searchForm").submit();
				}
			});


		});
	</script>
<#else>
	<tr>
		<td colspan="7" align="center">
			<p class="text-danger">目前没有符合要求的标</p>
			<script type="text/javascript">
				$(function(){
					//没查到内容将分页的条删除
					$("#page_container").empty().append($('<ul id="pagination" class="pagination"></ul>'));

				});
			</script>
		</td>
	</tr>
</#if>


