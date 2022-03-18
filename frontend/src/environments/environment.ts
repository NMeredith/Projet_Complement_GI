export const environment = {
  production: false,
  backend: {
    protocol: 'http',
    host: 'localhost',
    port: '8080',
    endpoints: {
      tousLesDocuments: '/document/?offset=:number',
      unDocument: '/document/:id',
      statsType: '/document/statsType',
      archiver: '/document/',
    }
  }
};
