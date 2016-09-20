FROM node:argon

#Make dir
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

RUN npm install -g swagger

COPY package.json /usr/src/app
RUN npm install

COPY . /usr/src/app
EXPOSE 8010

CMD ["node", "app.js"]