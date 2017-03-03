<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>书香中国</title>
<link href="/common/layout.css" rel="stylesheet" />
<link href="/common/yuelanshi.css" rel="stylesheet" />
<script type="text/javascript" src="/script/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/script/js.js"></script>
<script type="text/javascript" src="/script/tab.js"></script>
<script type="text/javascript" src="/script/vote.js"></script>
</head>

<body>
<div class="mtb10 layout">
	<div class="bb1 bns">
		<div class="tit1">
			<h2>文学专辑推荐</h2>
		</div>
		<div class="bookNews">
			<#if bookPackages0??>
			<#list bookPackages0 as bookPack>
			<div class="bookJs">
				<div class="img"><a href="#"><img src="${bookPack.package.price!''}"><span class="i">album</span></a></div>
				<h3><a href="#">${bookPack.package.name!''}</a></h3>
				<p><b>简介：</b>${bookPack.package.intro!''}</p>
				<div class="bookNews_div">
					<ul>
						<#list bookPack.bookList as book>
						<li><a href="/book/detail.action?bookId=${book.bookId!''}">${book.name!''}</a></li>
						</#list>
					</ul>
				</div>
			</div>
			</#list>
			</#if>
		</div>
		<div class="line1"></div>
		<div class="tit1">
			<h2>英语专辑推荐</h2>
		</div>
		<div class="bookNews">
			<#if bookPackages1??>
			<#list bookPackages1 as bookPack>
			<div class="bookJs">
				<div class="img"><a href="#"><img src="${bookPack.package.price!''}"><span class="i">album</span></a></div>
				<h3><a href="#">${bookPack.package.name!''}</a></h3>
				<p><b>简介：</b>${bookPack.package.intro!''}</p>
				<div class="bookNews_div">
					<ul>
						<#list bookPack.bookList as book>
						<li><a href="/book/detail.action?bookId=${book.bookId!''}">${book.name!''}</a></li>
						</#list>
					</ul>
				</div>
			</div>
			</#list>
			</#if>
		</div>
	</div>
</div>

<div class="mtb10 layout">
	<div class="bb1 bns">
		<div class="bns_tit">
			<ul>
				<li id="bns1_btn0" onclick=" tabit('bns1',0,3,'hot')" class="hot_a">历史类</li>
				<li id="bns1_btn1" onclick=" tabit('bns1',1,3,'hot')">科教类</li>
				<li id="bns1_btn2" onclick=" tabit('bns1',2,3,'hot')">传记类</li>
			</ul>
		</div>
		<div id="bns1_div0" class="bns_con">
			<div id="bnsc1_div0" class="bookNews">
				<#if bookPackages2['1']??>
				<#list bookPackages2['1'] as bookPack>
				<div class="bookJs">
					<div class="img"><a href="#"><img src="${bookPack.price!''}"><span class="i">album</span></a></div>
					<h3><a href="#">${bookPack.name!''}</a></h3>
					<p><b>简介：</b>${bookPack.intro!''}</p>
					<div class="bookNews_div">
						<ul>
						</ul>
					</div>
				</div>
				</#list>
				</#if>
			</div>
			<div id="bnsc1_div1" class="bookNews" style="display:none;">
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑22222</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑2222</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div id="bnsc1_div2" class="bookNews" style="display:none;">
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑3333</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑333</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
			</div>
			<ul class="bookTab2">
				<li id="bnsc1_btn0" onclick=" tabit('bnsc1',0,3,'hot')" class="hot_a">1</li>
				<li id="bnsc1_btn1" onclick=" tabit('bnsc1',1,3,'hot')">2</li>
				<li id="bnsc1_btn2" onclick=" tabit('bnsc1',2,3,'hot')">3</li>
			</ul>
		</div>
		<div id="bns1_div1" class="bns_con" style="display:none;">
			<div id="bnsc2_div0" class="bookNews">
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div id="bnsc2_div1" class="bookNews" style="display:none;">
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑22222</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑2222</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div id="bnsc2_div2" class="bookNews" style="display:none;">
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑3333</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑333</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
			</div>
			<ul class="bookTab2">
				<li id="bnsc2_btn0" onclick=" tabit('bnsc2',0,3,'hot')" class="hot_a">1</li>
				<li id="bnsc2_btn1" onclick=" tabit('bnsc2',1,3,'hot')">2</li>
				<li id="bnsc2_btn2" onclick=" tabit('bnsc2',2,3,'hot')">3</li>
			</ul>
		</div>
		<div id="bns1_div2" class="bns_con" style="display:none;">
			<div id="bnsc3_div0" class="bookNews">
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div id="bnsc3_div1" class="bookNews" style="display:none;">
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑22222</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑2222</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div id="bnsc3_div2" class="bookNews" style="display:none;">
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑3333</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
				<div class="bookJs">
					<div class="img"><a href="#"><img src="images/85x120.jpg"><span class="i">album</span></a></div>
					<h3><a href="#">班主任必读专辑333</a></h3>
					<p><b>简介：</b>字细密，信息量大，像个电影里的长镜头，从从容容地白描。字细密，信息量大，像个电影里的长镜头，从从容容地白描。</p>
					<div class="bookNews_div">
						<ul>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
							<li><a href="#">神经漫游者</a></li>
						</ul>
					</div>
				</div>
			</div>
			<ul class="bookTab2">
				<li id="bnsc3_btn0" onclick=" tabit('bnsc3',0,3,'hot')" class="hot_a">1</li>
				<li id="bnsc3_btn1" onclick=" tabit('bnsc3',1,3,'hot')">2</li>
				<li id="bnsc3_btn2" onclick=" tabit('bnsc3',2,3,'hot')">3</li>
			</ul>
		</div>
	</div>
</div>

</body>
</html>