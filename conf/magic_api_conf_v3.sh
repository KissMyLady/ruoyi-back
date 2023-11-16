{
    baseURL: 'http://localhost:9999/magic/web', //必填
    serverURL: 'http://localhost:9999/',    // 必填
    title: 'magic-api',
    theme: 'default',
    defaultExpand: true,
    checkUpdate: true,
    jdbcDrivers:['driver1','driver2'],
    datasourceTypes:['type1', 'type2'],
    options: [['key1', '描述','defaultValue1'],['key2','描述','defaultValue2']],
    blockClose: true,   // 是否阻止离开页面
    autoSave: true,
    decorationTimeout: 10000,
    logMaxRows: Infinity,
    editorFontFamily: 'JetBrainsMono, Consolas, "Courier New",monospace, 微软雅黑',
    editorFontSize: 14,
    fontLigatures: true,
    header: {
        skin: true,
        document: true,
        repo: true,
        qqGroup: true
    },
    getMagicTokenValue: function(){
      // 自行获取magic-api需要的token
      return token;
    },
    request: {
        beforeSend: function (config) {
            console.log('请求设置', config);
            return config;
        },
        onError: function (err) {
            console.log('请求出错');
            return Promise.reject(err)
        }
    },
    response: {
        onSuccess: function(resp){console.log('请求成功',resp);return resp;},
        onError: function(err){console.log('请求出错');return Promise.reject(err)},
    },
}